package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.core.annotation.*;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RequestMapping("/v1/banner")
@RestController
@Validated
@PermissionModule(value = "Banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping("/page")
    @LoginRequired
    public PageResponseVO<BannerDO> page(@RequestParam(required = false,defaultValue = "0") @Min(value = 0) Integer page,
                                     @RequestParam(required = false,defaultValue = "10") @Min(value = 1) @Max(value = 30) Integer count){
        //start count 适合移动端的分页
        //传统分页 page count
        Page<BannerDO> pager = new Page<>(page,count);
        IPage<BannerDO> paging = bannerService.getBaseMapper().selectPage(pager,null);
        return new PageResponseVO<>(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }
    //三种返回形式
    //1.Page
    //2.查询到资源的JSON BannerDO
    //3. UnifyResponseVo

    @PutMapping("/{id}")
    @PermissionMeta(value = "更新Banner")
    @GroupRequired
    public UpdatedVO updateBanner(@RequestBody @Validated BannerDTO dto,
                            @PathVariable @Positive Long id){
        bannerService.update(dto,id);
        return new UpdatedVO();

    }

    @DeleteMapping("/{id}")
    @PermissionMeta(value = "删除Banner")
    @GroupRequired
    public DeletedVO deleteBanner(@PathVariable @Positive Long id){
        bannerService.delete(id);
        return new DeletedVO();
        //级联删除 软删除 逻辑删除
        //banner banner_item
        //1.id  2.查询 banner_item_id  循环删除
        //this.getBaseMapper().deleteBatchIds()  不需要遍历删除
    }

    @GetMapping("/{id}")
    @LoginRequired
    @PermissionMeta(value = "查询Banner")
    //行为日志 搭配PermissionMeta
    @Logger(template = "{user.username}查询了Banner数据")
    public BannerWithItemsBO getWithItems(@PathVariable @Positive Long id){
        return bannerService.getWithItems(id);
    }

    @PostMapping
    @PermissionMeta("新增Banner")
    @GroupRequired
    public CreatedVO createBanner(@RequestBody @Validated BannerDTO dto){
        BannerDO bannerDO = new BannerDO();
        BeanUtils.copyProperties(dto,bannerDO);
        this.bannerService.save(bannerDO);
        return new CreatedVO();
    }

    /**
     * 基于API的权限控制
     * @LoginRequired
     * 必须要登录
     *
     * @AdminRequired
     * 必须要登录,且分组为管理员  只有管理员能访问
     *
     * @PermissionMeta(value="删除Banner",module="Banner")
     * 指定模块,分组  但可以访问  指定接口元数据信息
     * @GroupRequired  分组权限                    管理员和分组用户能访问
     * 接口保护
     *
     * @PermissionModule
     * 标明模块
     *
     *Root  Guest
     *
     * 细粒度的权限控制  字段进行权限控制
     * 动态SQL拼接
     * select banner.name banner.id ...
     * 繁琐
     *
     * 小程序里单令牌已足够 code 可以换
     *
     *  web H5 双令牌 access_token  refresh_token
     *
     *
     *  Mapper  extends
     *  开启 autoMapping
     *
     *  多表查询：
     *      1.全部单表查询
     *      2.多次的JoIN ON
     *      3.结合起来使用
     *
     *
     *  一个多对多 可以拆分为 两个一对多
     */



}
