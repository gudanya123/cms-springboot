package io.github.talelin.latticy.vo;

import lombok.*;

import java.util.List;

/**
 * 分页数据统一 view object
 *
 * @author pedro@TaleLin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponseVO<T> {

    private Long total;

    private List<T> items;

    private Long page;

    private Long count;

    public PageResponseVO(long total, List<T> records, long current, long size) {
        this.total = total;
        this.items = records;
        this.page = current;
        this.count = size;
    }
}
