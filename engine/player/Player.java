package player;

public abstract class Player {
    private boolean whiteSide;
    private boolean human;

    public Player(boolean white, boolean human) {
        this.whiteSide = white;
        this.human = human;
    }

    public boolean isWhite() {
        return this.whiteSide;
    }

    public boolean isHuman() {
        return this.human;
    }
}
