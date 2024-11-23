package DesignPattern;

public class House {
    private String walls;
    private String roof;
    private int windows;
    private boolean garden;
    private boolean garage;

    private House(Builder builder) {
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.windows = builder.windows;
        this.garden = builder.garden;
        this.garage = builder.garage;
    }

    @Override
    public String toString() {
        return "House [walls=" + walls + ", roof=" + roof + ", windows=" + windows + ", garden=" + garden + ", garage=" + garage + "]";
    }

    public static class Builder {
        private String walls;
        private String roof;
        private int windows;
        private boolean garden;
        private boolean garage;

        public Builder setWalls(String walls) {
            this.walls = walls;
            return this;
        }

        public Builder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public Builder setWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public Builder setGarden(boolean garden) {
            this.garden = garden;
            return this;
        }

        public Builder setGarage(boolean garage) {
            this.garage = garage;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    public static void main(String[] args) {
        House house = new House.Builder()
                .setWalls("Brick")
                .setRoof("Concrete")
                .setWindows(4)
                .setGarden(true)
                .setGarage(false)
                .build();

        System.out.println(house);
    }
}
