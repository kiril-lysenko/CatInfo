package com.self.education.catinfo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.self.education.catinfo.api.CatsColorInfoResponse;
import com.self.education.catinfo.domain.CatColorsInfo;
import com.self.education.catinfo.mapper.CatColorInfoMapper;
import com.self.education.catinfo.repository.CatColorsInfoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CatsStatisticServiceImpl implements CatsStatisticService {

    private final CatColorsInfoRepository catColorsInfoRepository;
    private final CatColorInfoMapper catColorInfoMapper;

    @Override
    public List<CatsColorInfoResponse> createCatColorsInfo() {
        final List<CatColorsInfo> catColorsInfo = catColorsInfoRepository.countCatsByColor();
        catColorsInfo.forEach(this::createOrUpdate);
        return catColorsInfoRepository.findAll().stream().map(catColorInfoMapper::transform).toList();
    }

    private void createOrUpdate(final CatColorsInfo catColorInfo) {
        final Optional<CatColorsInfo> existing = catColorsInfoRepository.findByColor(catColorInfo.getCatColor().name());
        if (existing.isPresent()) {
            catColorsInfoRepository.update(catColorInfo.getCatColor().name(), catColorInfo.getCount());
        } else {
            catColorsInfoRepository.save(catColorInfo.getCatColor().name(), catColorInfo.getCount());
        }
    }
}
