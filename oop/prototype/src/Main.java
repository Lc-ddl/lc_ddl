class GameCharacter{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String type;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    private int hp;
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {this.hp = hp;}

    private int attack;
    public int getAttack() {return attack;}
    public void setAttack(int attack){this.attack = attack;}

    private int defense;
    public int getDefense() {return defense;}
    public void setDefense(int defense){this.defense = defense;}
}

