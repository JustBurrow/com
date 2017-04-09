package com.borderline.web.converter;

import com.borderline.web.dto.SiteDto;
import com.domain.web.Site;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public interface SiteDtoConverter extends DtoConverter<Site, SiteDto, PagingDtoConvertContext> {
}
