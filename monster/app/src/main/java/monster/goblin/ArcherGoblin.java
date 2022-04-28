package monster.goblin;

public class ArcherGoblin extends Goblin{
    @Override
    public String getGoblinType() {
        return "고블린 궁수";
    }

    @Override
    public String getGoblinSkill() {
        return "에로우 블로우";
    }

    @Override
    public int getGoblinHp() {
        return 380;
    }

    @Override
    public int getGoblinDamage() {
        return 60;
    }

    @Override
    public String toString() {
        return "🏹("+getGoblinType()+"/hp:"+getGoblinHp()+")으로부터 " + getGoblinSkill() + "을(를) 맞았습니다. " + getGoblinDamage() + "만큼 피해를 입습니다.";
    }
}
