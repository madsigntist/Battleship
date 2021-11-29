package battleship;

public class Ship {
    private final ShipType shipType;
    private int hitPoints;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        hitPoints = shipType.getLength();
    }

    public ShipType getShipType() {
        return shipType;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void getHit() {
        --hitPoints;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public enum ShipType {
        Carrier("Aircraft Carrier", 5),
        Battleship("Battleship", 4),
        Submarine("Submarine", 3),
        Cruiser("Cruiser", 3),
        Destroyer("Destroyer", 2);

        private final String name;
        private final int length;

        ShipType(String name, int length) {
            this.name = name;
            this.length = length;
        }

        public String getName() {
            return this.name;
        }

        public int getLength() {
            return this.length;
        }
    }
}
