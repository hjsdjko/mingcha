
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
 * 茶叶
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chaye")
public class ChayeController {
    private static final Logger logger = LoggerFactory.getLogger(ChayeController.class);

    private static final String TABLE_NAME = "chaye";

    @Autowired
    private ChayeService chayeService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private ChayeCollectionService chayeCollectionService;//茶叶收藏
    @Autowired
    private ChayeCommentbackService chayeCommentbackService;//茶叶评价
    @Autowired
    private ChayeOrderService chayeOrderService;//茶叶订单
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
        params.put("chayeDeleteStart",1);params.put("chayeDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = chayeService.queryPage(params);

        //字典表数据转换
        List<ChayeView> list =(List<ChayeView>)page.getList();
        for(ChayeView c:list){
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
        ChayeEntity chaye = chayeService.selectById(id);
        if(chaye !=null){
            //entity转view
            ChayeView view = new ChayeView();
            BeanUtils.copyProperties( chaye , view );//把实体数据重构到view中
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
    public R save(@RequestBody ChayeEntity chaye, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chaye:{}",this.getClass().getName(),chaye.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChayeEntity> queryWrapper = new EntityWrapper<ChayeEntity>()
            .eq("chaye_name", chaye.getChayeName())
            .eq("chaye_address", chaye.getChayeAddress())
            .eq("zan_number", chaye.getZanNumber())
            .eq("cai_number", chaye.getCaiNumber())
            .eq("chaye_types", chaye.getChayeTypes())
            .eq("chaye_kucun_number", chaye.getChayeKucunNumber())
            .eq("chaye_cangku", chaye.getChayeCangku())
            .eq("shangxia_types", chaye.getShangxiaTypes())
            .eq("chaye_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChayeEntity chayeEntity = chayeService.selectOne(queryWrapper);
        if(chayeEntity==null){
            chaye.setZanNumber(1);
            chaye.setCaiNumber(1);
            chaye.setChayeClicknum(1);
            chaye.setShangxiaTypes(1);
            chaye.setChayeDelete(1);
            chaye.setInsertTime(new Date());
            chaye.setCreateTime(new Date());
            chayeService.insert(chaye);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChayeEntity chaye, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chaye:{}",this.getClass().getName(),chaye.toString());
        ChayeEntity oldChayeEntity = chayeService.selectById(chaye.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chaye.getChayePhoto()) || "null".equals(chaye.getChayePhoto())){
                chaye.setChayePhoto(null);
        }
        if("".equals(chaye.getChayeContent()) || "null".equals(chaye.getChayeContent())){
                chaye.setChayeContent(null);
        }

            chayeService.updateById(chaye);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChayeEntity> oldChayeList =chayeService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ChayeEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChayeEntity chayeEntity = new ChayeEntity();
            chayeEntity.setId(id);
            chayeEntity.setChayeDelete(2);
            list.add(chayeEntity);
        }
        if(list != null && list.size() >0){
            chayeService.updateBatchById(list);
        }

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
            List<ChayeEntity> chayeList = new ArrayList<>();//上传的东西
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
                            ChayeEntity chayeEntity = new ChayeEntity();
//                            chayeEntity.setChayeName(data.get(0));                    //茶叶名称 要改的
//                            chayeEntity.setChayeUuidNumber(data.get(0));                    //茶叶编号 要改的
//                            chayeEntity.setChayePhoto("");//详情和图片
//                            chayeEntity.setChayeAddress(data.get(0));                    //产茶地点 要改的
//                            chayeEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            chayeEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            chayeEntity.setChayeTypes(Integer.valueOf(data.get(0)));   //茶叶类型 要改的
//                            chayeEntity.setChayeKucunNumber(Integer.valueOf(data.get(0)));   //茶叶库存 要改的
//                            chayeEntity.setChayeOldMoney(data.get(0));                    //茶叶原价 要改的
//                            chayeEntity.setChayeNewMoney(data.get(0));                    //现价/斤 要改的
//                            chayeEntity.setChayeCangku(data.get(0));                    //所属仓库 要改的
//                            chayeEntity.setChayeClicknum(Integer.valueOf(data.get(0)));   //茶叶热度 要改的
//                            chayeEntity.setChayeContent("");//详情和图片
//                            chayeEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            chayeEntity.setChayeDelete(1);//逻辑删除字段
//                            chayeEntity.setInsertTime(date);//时间
//                            chayeEntity.setCreateTime(date);//时间
                            chayeList.add(chayeEntity);


                            //把要查询是否重复的字段放入map中
                                //茶叶编号
                                if(seachFields.containsKey("chayeUuidNumber")){
                                    List<String> chayeUuidNumber = seachFields.get("chayeUuidNumber");
                                    chayeUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chayeUuidNumber = new ArrayList<>();
                                    chayeUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chayeUuidNumber",chayeUuidNumber);
                                }
                        }

                        //查询是否重复
                         //茶叶编号
                        List<ChayeEntity> chayeEntities_chayeUuidNumber = chayeService.selectList(new EntityWrapper<ChayeEntity>().in("chaye_uuid_number", seachFields.get("chayeUuidNumber")).eq("chaye_delete", 1));
                        if(chayeEntities_chayeUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChayeEntity s:chayeEntities_chayeUuidNumber){
                                repeatFields.add(s.getChayeUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [茶叶编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chayeService.insertBatch(chayeList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ChayeView> returnChayeViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("chayeYesnoTypes",2);
        PageUtils pageUtils = chayeOrderService.queryPage(params1);
        List<ChayeOrderView> orderViewsList =(List<ChayeOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ChayeOrderView orderView:orderViewsList){
            Integer chayeTypes = orderView.getChayeTypes();
            if(typeMap.containsKey(chayeTypes)){
                typeMap.put(chayeTypes,typeMap.get(chayeTypes)+1);
            }else{
                typeMap.put(chayeTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("chayeTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("chayeYesnoTypes",2);
            PageUtils pageUtils1 = chayeService.queryPage(params2);
            List<ChayeView> chayeViewList =(List<ChayeView>)pageUtils1.getList();
            returnChayeViewList.addAll(chayeViewList);
            if(returnChayeViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("chayeYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = chayeService.queryPage(params);
        if(returnChayeViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnChayeViewList.size();//要添加的数量
            List<ChayeView> chayeViewList =(List<ChayeView>)page.getList();
            for(ChayeView chayeView:chayeViewList){
                Boolean addFlag = true;
                for(ChayeView returnChayeView:returnChayeViewList){
                    if(returnChayeView.getId().intValue() ==chayeView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnChayeViewList.add(chayeView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnChayeViewList = returnChayeViewList.subList(0, limit);
        }

        for(ChayeView c:returnChayeViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnChayeViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chayeService.queryPage(params);

        //字典表数据转换
        List<ChayeView> list =(List<ChayeView>)page.getList();
        for(ChayeView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChayeEntity chaye = chayeService.selectById(id);
            if(chaye !=null){

                //点击数量加1
                chaye.setChayeClicknum(chaye.getChayeClicknum()+1);
                chayeService.updateById(chaye);

                //entity转view
                ChayeView view = new ChayeView();
                BeanUtils.copyProperties( chaye , view );//把实体数据重构到view中

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
    public R add(@RequestBody ChayeEntity chaye, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chaye:{}",this.getClass().getName(),chaye.toString());
        Wrapper<ChayeEntity> queryWrapper = new EntityWrapper<ChayeEntity>()
            .eq("chaye_name", chaye.getChayeName())
            .eq("chaye_uuid_number", chaye.getChayeUuidNumber())
            .eq("chaye_address", chaye.getChayeAddress())
            .eq("zan_number", chaye.getZanNumber())
            .eq("cai_number", chaye.getCaiNumber())
            .eq("chaye_types", chaye.getChayeTypes())
            .eq("chaye_kucun_number", chaye.getChayeKucunNumber())
            .eq("chaye_cangku", chaye.getChayeCangku())
            .eq("chaye_clicknum", chaye.getChayeClicknum())
            .eq("shangxia_types", chaye.getShangxiaTypes())
            .eq("chaye_delete", chaye.getChayeDelete())
//            .notIn("chaye_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChayeEntity chayeEntity = chayeService.selectOne(queryWrapper);
        if(chayeEntity==null){
                chaye.setZanNumber(1);
                chaye.setCaiNumber(1);
            chaye.setChayeClicknum(1);
            chaye.setChayeDelete(1);
            chaye.setInsertTime(new Date());
            chaye.setCreateTime(new Date());
        chayeService.insert(chaye);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

