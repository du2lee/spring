package monster.goblin;

public class GoblinCreator extends GoblinFactory{

    @Override
    public Goblin createGoblin(String type) {
        switch (type){
            case "archer": return new ArcherGoblin();
            case "thief": return new ThiefGoblin();
        }
        return null;
    }
}
