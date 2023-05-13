package etc;

public class SkillTree {
    public int solution(String skill, String[] skill_trees){
      int answer = 0;

      for(String skillTree: skill_trees){
        String tempSkill = skillTree;

        //skill의 알파벳이 아니면 -> ""로 replace하기
        for (int i = 0; i < skillTree.length(); i++) {
          String s = skillTree.substring(i, i+1);
          if(!skill.contains(s)){
            tempSkill = tempSkill.replace(s, "");
          }

        }

        //indexOf()이
        if (skill.indexOf(tempSkill) == 0) {
          answer++;
        }
      }



      return answer;
    }

  public static void main(String[] args) {
    SkillTree skillTree = new SkillTree();
    String skill = "CBD";
    String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
    String[] skill_trees2 = {"C","D","CB","BDA"};

    System.out.println(skillTree.solution(skill, skill_trees));
    System.out.println(skillTree.solution(skill, skill_trees2));

  }
}