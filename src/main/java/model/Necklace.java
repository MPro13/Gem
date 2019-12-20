package model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Necklace {

    private List<Gem> gemList = new ArrayList<>();

    private String name;

    private int amountOfGems;

    private int weight;

    private int price;

    public void count() {
        weight = price = 0;
        amountOfGems = gemList.size();
        for (Gem gem : gemList) {
            price += gem.getPrice();
            weight += gem.getWeight();
        }
    }
}
