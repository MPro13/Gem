package model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Gem {

    private String name;

    private int weight;

    private int price;

    private int transparency;
}
