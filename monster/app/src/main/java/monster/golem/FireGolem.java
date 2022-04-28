package monster.golem;

public class FireGolem extends Golem{
    @Override
    public String getGolemType() {
        return "파이어골렘";
    }

    @Override
    public String getGolemSkill() {
        return "화염포";
    }

    @Override
    public int getGolemHp() {
        return 1840;
    }

    @Override
    public int getGolemDamage() {
        return 2420;
    }

    @Override
    public String toString() {
        return "🔥("+getGolemType()+"/hp:"+getGolemDamage()+")으로부터 " + getGolemSkill() + "을(를) 맞았습니다. " + getGolemDamage() + "만큼 피해를 입습니다.";
    }
}
