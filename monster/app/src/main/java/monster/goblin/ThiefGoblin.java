package monster.goblin;

public class ThiefGoblin extends Goblin{
    @Override
    public String getGoblinType() {
        return "고블린 도적";
    }

    @Override
    public String getGoblinSkill() {
        return "라이징 컷";
    }

    @Override
    public int getGoblinHp() {
        return 560;
    }

    @Override
    public int getGoblinDamage() {
        return 30;
    }

    @Override
    public String toString() {
        return "🗡("+getGoblinType()+"/hp:"+getGoblinHp()+")으로부터 " + getGoblinSkill() + "을(를) 맞았습니다. " + getGoblinDamage() + "만큼 피해를 입습니다.";
    }
}
