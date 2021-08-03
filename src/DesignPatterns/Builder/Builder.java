package DesignPatterns.Builder;

import DesignPatterns.Builder.Entitys.Pizza;

public interface Builder {

    public Builder setName(String name);

    public Builder addCheese(String... cheese);

    public Builder addItem(String... item);

    public Builder addSauce(String... sauce);

    public Pizza build();

}
