package top.fqq.familytree.bean.dto.person;

import lombok.Data;
import top.fqq.familytree.bean.dto.BaseDto;

/**
 * @author fitch
 * @date 2021/9/26 16:09
 */
@Data
public class PersonDeleteDto extends BaseDto {
    /**
     * 编号
     */
    private String id;

    private static final long serialVersionUID = 1L;
}
