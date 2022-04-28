package monster.golem;

public class GolemCreator extends GolemFactory{
    @Override
    public Golem createGolem(String type) {
        switch (type){
            case "fire": return new FireGolem();
            case "ice": return new IceGolem();
        }
        return null;
    }
}
