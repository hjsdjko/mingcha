
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 茶叶订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chayeOrder")
public class ChayeOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ChayeOrderController.class);

    private static final String TABLE_NAME = "chayeOrder";

    @Autowired
    private ChayeOrderService chayeOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private ChayeService chayeService;//茶叶
    @Autowired
    private ChayeCollectionService chayeCollectionService;//茶叶收藏
    @Autowired
    private ChayeCommentbackService chayeCommentbackService;//茶叶评价
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LishijieshaoService lishijieshaoService;//茗茶历史
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = chayeOrderService.queryPage(params);

        //字典表数据转换
        List<ChayeOrderView> list =(List<ChayeOrderView>)page.getList();
        for(ChayeOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChayeOrderEntity chayeOrder = chayeOrderService.selectById(id);
        if(chayeOrder !=null){
            //entity转view
            ChayeOrderView view = new ChayeOrderView();
            BeanUtils.copyProperties( chayeOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(chayeOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 茶叶
            //级联表
            ChayeEntity chaye = chayeService.selectById(chayeOrder.getChayeId());
            if(chaye != null){
            BeanUtils.copyProperties( chaye , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChayeId(chaye.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(chayeOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChayeOrderEntity chayeOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chayeOrder:{}",this.getClass().getName(),chayeOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chayeOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        chayeOrder.setCreateTime(new Date());
        chayeOrder.setInsertTime(new Date());
        chayeOrderService.insert(chayeOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChayeOrderEntity chayeOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chayeOrder:{}",this.getClass().getName(),chayeOrder.toString());
        ChayeOrderEntity oldChayeOrderEntity = chayeOrderService.selectById(chayeOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chayeOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            chayeOrderService.updateById(chayeOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChayeOrderEntity> oldChayeOrderList =chayeOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chayeOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ChayeOrderEntity> chayeOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChayeOrderEntity chayeOrderEntity = new ChayeOrderEntity();
//                            chayeOrderEntity.setChayeOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            chayeOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            chayeOrderEntity.setChayeId(Integer.valueOf(data.get(0)));   //茶叶 要改的
//                            chayeOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chayeOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            chayeOrderEntity.setChayeOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            chayeOrderEntity.setChayeOrderCourierName(data.get(0));                    //快递公司 要改的
//                            chayeOrderEntity.setChayeOrderCourierNumber(data.get(0));                    //快递单号 要改的
//                            chayeOrderEntity.setChayeOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            chayeOrderEntity.setChayeOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            chayeOrderEntity.setInsertTime(date);//时间
//                            chayeOrderEntity.setCreateTime(date);//时间
                            chayeOrderList.add(chayeOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("chayeOrderUuidNumber")){
                                    List<String> chayeOrderUuidNumber = seachFields.get("chayeOrderUuidNumber");
                                    chayeOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chayeOrderUuidNumber = new ArrayList<>();
                                    chayeOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chayeOrderUuidNumber",chayeOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<ChayeOrderEntity> chayeOrderEntities_chayeOrderUuidNumber = chayeOrderService.selectList(new EntityWrapper<ChayeOrderEntity>().in("chaye_order_uuid_number", seachFields.get("chayeOrderUuidNumber")));
                        if(chayeOrderEntities_chayeOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChayeOrderEntity s:chayeOrderEntities_chayeOrderUuidNumber){
                                repeatFields.add(s.getChayeOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chayeOrderService.insertBatch(chayeOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chayeOrderService.queryPage(params);

        //字典表数据转换
        List<ChayeOrderView> list =(List<ChayeOrderView>)page.getList();
        for(ChayeOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChayeOrderEntity chayeOrder = chayeOrderService.selectById(id);
            if(chayeOrder !=null){


                //entity转view
                ChayeOrderView view = new ChayeOrderView();
                BeanUtils.copyProperties( chayeOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(chayeOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    ChayeEntity chaye = chayeService.selectById(chayeOrder.getChayeId());
                if(chaye != null){
                    BeanUtils.copyProperties( chaye , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChayeId(chaye.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chayeOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChayeOrderEntity chayeOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chayeOrder:{}",this.getClass().getName(),chayeOrder.toString());
            ChayeEntity chayeEntity = chayeService.selectById(chayeOrder.getChayeId());
            if(chayeEntity == null){
                return R.error(511,"查不到该茶叶");
            }
            // Double chayeNewMoney = chayeEntity.getChayeNewMoney();

            if(false){
            }
            else if(chayeEntity.getChayeNewMoney() == null){
                return R.error(511,"现价/斤不能为空");
            }
            else if((chayeEntity.getChayeKucunNumber() -chayeOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - chayeEntity.getChayeNewMoney()*chayeOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            chayeOrder.setChayeOrderTypes(101); //设置订单状态为已支付
            chayeOrder.setChayeOrderTruePrice(chayeEntity.getChayeNewMoney()*chayeOrder.getBuyNumber()); //设置实付价格
            chayeOrder.setYonghuId(userId); //设置订单支付人id
            chayeOrder.setChayeOrderUuidNumber(String.valueOf(new Date().getTime()));
            chayeOrder.setChayeOrderPaymentTypes(1);
            chayeOrder.setInsertTime(new Date());
            chayeOrder.setCreateTime(new Date());
                chayeEntity.setChayeKucunNumber( chayeEntity.getChayeKucunNumber() -chayeOrder.getBuyNumber());
                chayeService.updateById(chayeEntity);
                chayeOrderService.insert(chayeOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String chayeOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

            Integer chayeOrderPaymentTypes = Integer.valueOf(String.valueOf(params.get("chayeOrderPaymentTypes")));//支付类型

        String data = String.valueOf(params.get("chayes"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> chayes = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<ChayeOrderEntity> chayeOrderList = new ArrayList<>();
        //商品表
        List<ChayeEntity> chayeList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : chayes) {
           //取值
            Integer chayeId = Integer.valueOf(String.valueOf(map.get("chayeId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            ChayeEntity chayeEntity = chayeService.selectById(chayeId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));

            //判断商品的库存是否足够
            if(chayeEntity.getChayeKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(chayeEntity.getChayeName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                chayeEntity.setChayeKucunNumber(chayeEntity.getChayeKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            ChayeOrderEntity chayeOrderEntity = new ChayeOrderEntity<>();

            //赋值订单信息
            chayeOrderEntity.setChayeOrderUuidNumber(chayeOrderUuidNumber);//订单编号
            chayeOrderEntity.setAddressId(addressId);//收货地址
            chayeOrderEntity.setChayeId(chayeId);//茶叶
                        chayeOrderEntity.setYonghuId(userId);//用户
            chayeOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            chayeOrderEntity.setChayeOrderTypes(101);//订单类型
            chayeOrderEntity.setChayeOrderPaymentTypes(chayeOrderPaymentTypes);//支付类型
            chayeOrderEntity.setInsertTime(new Date());//订单创建时间
            chayeOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(chayeOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(chayeEntity.getChayeNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额


                    chayeOrderEntity.setChayeOrderTruePrice(money);

                }
            }
            chayeOrderList.add(chayeOrderEntity);
            chayeList.add(chayeEntity);

        }
        chayeOrderService.insertBatch(chayeOrderList);
        chayeService.updateBatchById(chayeList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);

        return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            ChayeOrderEntity chayeOrder = chayeOrderService.selectById(id);//当前表service
            Integer buyNumber = chayeOrder.getBuyNumber();
            Integer chayeOrderPaymentTypes = chayeOrder.getChayeOrderPaymentTypes();
            Integer chayeId = chayeOrder.getChayeId();
            if(chayeId == null)
                return R.error(511,"查不到该茶叶");
            ChayeEntity chayeEntity = chayeService.selectById(chayeId);
            if(chayeEntity == null)
                return R.error(511,"查不到该茶叶");
            Double chayeNewMoney = chayeEntity.getChayeNewMoney();
            if(chayeNewMoney == null)
                return R.error(511,"茶叶价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(chayeOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = chayeEntity.getChayeNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            }

            chayeEntity.setChayeKucunNumber(chayeEntity.getChayeKucunNumber() + buyNumber);

            chayeOrder.setChayeOrderTypes(102);//设置订单状态为已退款
            chayeOrderService.updateAllColumnById(chayeOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            chayeService.updateById(chayeEntity);//更新订单中茶叶的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer chayeCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            ChayeOrderEntity chayeOrder = chayeOrderService.selectById(id);
        if(chayeOrder == null)
            return R.error(511,"查不到该订单");
        Integer chayeId = chayeOrder.getChayeId();
        if(chayeId == null)
            return R.error(511,"查不到该茶叶");

        ChayeCommentbackEntity chayeCommentbackEntity = new ChayeCommentbackEntity();
            chayeCommentbackEntity.setId(id);
            chayeCommentbackEntity.setChayeId(chayeId);
            chayeCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            chayeCommentbackEntity.setChayeCommentbackText(commentbackText);
            chayeCommentbackEntity.setInsertTime(new Date());
            chayeCommentbackEntity.setReplyText(null);
            chayeCommentbackEntity.setUpdateTime(null);
            chayeCommentbackEntity.setCreateTime(new Date());
            chayeCommentbackService.insert(chayeCommentbackEntity);

            chayeOrder.setChayeOrderTypes(105);//设置订单状态为已评价
            chayeOrderService.updateById(chayeOrder);//根据id更新
            return R.ok();
    }

    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String chayeOrderCourierNumber, String chayeOrderCourierName , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChayeOrderEntity  chayeOrderEntity = chayeOrderService.selectById(id);
        chayeOrderEntity.setChayeOrderTypes(103);//设置订单状态为已发货
        chayeOrderEntity.setChayeOrderCourierNumber(chayeOrderCourierNumber);
        chayeOrderEntity.setChayeOrderCourierName(chayeOrderCourierName);
        chayeOrderService.updateById( chayeOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChayeOrderEntity  chayeOrderEntity = chayeOrderService.selectById(id);
        chayeOrderEntity.setChayeOrderTypes(104);//设置订单状态为收货
        chayeOrderService.updateById( chayeOrderEntity);
        return R.ok();
    }

}

