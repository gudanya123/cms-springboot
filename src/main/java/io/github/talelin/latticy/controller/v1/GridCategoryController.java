package io.github.talelin.latticy.controller.v1;


import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.LoginRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.core.annotation.PermissionModule;
import io.github.talelin.latticy.dto.GridCategoryDTO;
import io.github.talelin.latticy.service.GridCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.GridCategoryDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Positive;

import java.util.List;

/**
* @author generator@TaleLin
* @since 2021-07-30
*/
@RestController
@RequestMapping("/v1/grid-category")
@Validated
@PermissionModule("六宫格")
public class GridCategoryController {

    @Autowired
    private GridCategoryService gridCategoryService;

    @PostMapping("")
    @PermissionMeta("新增GridCategory")
    @GroupRequired
    public CreatedVO create(@RequestBody @Validated GridCategoryDTO dto) {
        gridCategoryService.createGridCategory(dto);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    @PermissionMeta("修改GridCategory")
    @GroupRequired
    public UpdatedVO update(@RequestBody @Validated GridCategoryDTO dto,
                            @PathVariable @Positive(message = "{id.positive}") Integer id) {
        gridCategoryService.updateGridCategory(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    @PermissionMeta("删除GridCategory")
    @GroupRequired
    public DeletedVO delete(@PathVariable @Positive(message = "{id.positive}") Integer id) {
        gridCategoryService.deleteGridCategory(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    @PermissionMeta("获取GridCategory信息")
    @GroupRequired
    public GridCategoryDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        GridCategoryDO gridCategoryDO = gridCategoryService.getGridCategory(id);
        return gridCategoryDO;
    }

    @GetMapping("/list")
    @LoginRequired
    public List<GridCategoryDO> getList() {
        return gridCategoryService.list();
    }
}
