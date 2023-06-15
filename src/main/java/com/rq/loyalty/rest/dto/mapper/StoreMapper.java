package com.rq.loyalty.rest.dto.mapper;

import com.rq.loyalty.entity.Store;
import com.rq.loyalty.rest.dto.request.StoreRequestDTO;
import com.rq.loyalty.rest.dto.response.StoreResponseDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StoreMapper {

    public static Store toModel(StoreRequestDTO storeRequest) {
        return Store.builder()
                .documentCNPJ(storeRequest.getCNPJ())
                .name(storeRequest.getName())
                .build();
    }

    public static StoreResponseDTO toResponse(Store store) {
        return StoreResponseDTO.builder()
                .storeId(store.getStoreId())
                .createdAt(store.getCreatedAt())
                .CNPJ(store.getDocumentCNPJ())
                .name(store.getName())
                .build();
    }

    public static List<StoreResponseDTO> toResponseList(List<Store> storeList) {
        if (Objects.isNull(storeList) || storeList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return storeList.stream().map(StoreMapper::toResponse).collect(Collectors.toList());
        }
    }

}
