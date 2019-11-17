package aho.uozu;

public class PlayerInput {
    public PlayerInputType type;
    public Object value;

    public PlayerInput(PlayerInputType type) {
        this.type = type;
    }

    public PlayerInput(PlayerInputType type, Object value) {
        this.type = type;
        this.value = value;
    }
}
