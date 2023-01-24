package com.bootcamp.robotikka.robotikkaapi.dto.paginated;

import com.bootcamp.robotikka.robotikkaapi.dto.response.ResponseProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedProductDTO {
    private long count;
    private List<ResponseProductDTO> list;
}
