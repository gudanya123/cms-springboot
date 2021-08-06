package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.LoginRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.core.annotation.PermissionModule;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.ThemeDTO;
import io.github.talelin.latticy.dto.ThemeSpuDTO;
import io.github.talelin.latticy.model.SimplifySpuDO;
import io.github.talelin.latticy.service.ThemeService;
import io.github.talelin.latticy.service.ThemeSpuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.ThemeDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.util.List;

/**
* @author generator@TaleLin
* @since 2021-07-30
*/
@RestController
@RequestMapping("/v1/theme")
@PermissionModule("Theme")
@Validated
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private ThemeSpuService themeSpuService;

    @PostMapping("")
    @PermissionMeta("新增Theme")
    @GroupRequired
    public CreatedVO create(@RequestBody @Validated ThemeDTO dto) {
        ThemeDO themeDO = new ThemeDO();
        BeanUtils.copyProperties(dto,themeDO);
        themeService.save(themeDO);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    @PermissionMeta("更新Theme")
    @GroupRequired
    public UpdatedVO update(@RequestBody @Validated ThemeDTO dto,
                            @PathVariable @Positive(message = "{id.positive}") Integer id) {
        ThemeDO themeDO = themeService.getById(id);
        if(themeDO == null){
            throw new NotFoundException(30000);
        }
        BeanUtils.copyProperties(dto,themeDO);
        themeService.updateById(themeDO);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    @PermissionMeta("删除Theme")
    @GroupRequired
    public DeletedVO delete(@PathVariable @Positive(message = "{id.positive}") Integer id) {
        ThemeDO themeDO = themeService.getById(id);
        if(themeDO == null){
            throw new NotFoundException(30000);
        }
        themeService.getBaseMapper().deleteById(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    @PermissionMeta("获取Theme")
    @LoginRequired
    public ThemeDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        ThemeDO themeDO = themeService.getById(id);
        if(themeDO == null){
            throw new NotFoundException(30000);
        }
        return themeDO;
    }

    @GetMapping("/page")
    @PermissionMeta("获取Theme列表")
    @LoginRequired
    public PageResponseVO<ThemeDO> page(
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Integer page,
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Integer count
    ) {
        Page<ThemeDO> pager = new Page<>(page,count);
        IPage<ThemeDO> paging = themeService.getBaseMapper().selectPage(pager,null);
        return new PageResponseVO<>(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }

    @GetMapping("/spus")
    @PermissionMeta("获取Theme的Spu")
    @LoginRequired
    public List<SimplifySpuDO> getSpus(@RequestParam(name = "id") @Positive(message = "{id}") Integer id){
        return themeService.getSpus(id);
    }

    @PostMapping("/spu")
    @PermissionMeta("增加Theme的Spu")
    @GroupRequired
    public CreatedVO createThemeSpu(@RequestBody @Validated ThemeSpuDTO dto){
        themeService.createThemeSpu(dto);
        return new CreatedVO();
    }

    @GetMapping("/spu/list")
    @PermissionMeta("获取可以添加的Spu信息")
    @GroupRequired
    public List<SimplifySpuDO> getSpuList(@RequestParam(name = "id") @Positive(message = "{id}") Integer id) {
        return themeService.getSimplifySpus(id);
    }

    @DeleteMapping("/spu/{id}")
    @PermissionMeta("删除Theme的Spu")
    @GroupRequired
    public DeletedVO deleteSpu(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id){
        themeSpuService.deleteThemeSpu(id);
        return new DeletedVO();
    }


}
