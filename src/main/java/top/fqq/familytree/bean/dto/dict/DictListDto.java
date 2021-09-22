package top.fqq.familytree.bean.dto.dict;

import lombok.Data;
import top.fqq.familytree.bean.dto.BaseDto;

import java.io.Serializable;

/**
 * @author fitch
 * @date 2021/9/16 16:05
 */
@Data
public class DictListDto extends BaseDto implements Serializable {

    private String type;

    private String code;

}
