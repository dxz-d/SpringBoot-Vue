package com.evan.wj.dto.base;

import com.evan.wj.exception.BeanUtilsException;
import lombok.NonNull;

import static com.evan.wj.utils.BeanUtils.updateProperties;

/**
 * @description:
 * @author: dxz
 * @date: 2021/5/11 10:13
 */
public interface OutputConverter<DTO extends OutputConverter<DTO, DOMAIN>, DOMAIN> {

    @SuppressWarnings("/unchecked")
    @NonNull
    default <T extends DTO> T convertFrom(@NonNull DOMAIN domain) throws BeanUtilsException {
        updateProperties(domain, this);

        return (T) this;
    }
}
