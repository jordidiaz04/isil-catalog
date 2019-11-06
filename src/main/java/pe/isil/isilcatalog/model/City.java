package pe.isil.isilcatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {
    private Long id;
    private String name;
    private Long idCountry;
    private String pais;
}
