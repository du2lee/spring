package monster.golem;

public class IceGolem extends Golem{
    @Override
    public String getGolemType() {
        return "아이스골렘";
    }

    @Override
    public String getGolemSkill() {
        return "아이스빔";
    }

    @Override
    public int getGolemHp() {
        return 2350;
    }

    @Override
    public int getGolemDamage() {
        return 1530;
    }

    @Override
    public String toString() {
        return "🧊("+getGolemType()+"/hp:"+getGolemDamage()+")으로부터 " + getGolemSkill() + "을(를) 맞았습니다. " + getGolemDamage() + "만큼 피해를 입습니다.";
    }
}
