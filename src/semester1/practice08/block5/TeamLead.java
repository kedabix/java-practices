package semester1.practice08.block5;

import semester1.practice08.block2.Developer;

// Developer і Employee беремо із завдання 9 (пакет block2)
public class TeamLead extends Developer {
    private Developer[] teamMembers;
    private int memberCount;

    public TeamLead(String name, double salary, String programmingLanguage, int maxTeamSize) {
        super(name, salary, programmingLanguage);
        this.teamMembers = new Developer[maxTeamSize];
        this.memberCount = 0;
    }

    public void addTeamMember(Developer dev) {
        if (memberCount < teamMembers.length) {
            teamMembers[memberCount] = dev;
            memberCount++;
        } else {
            System.out.println("Команда заповнена, " + dev.getName() + " не додано");
        }
    }

    // Зарплата тімліда + зарплати всіх розробників
    public double getTotalTeamBudget() {
        double total = getSalary();
        for (int i = 0; i < memberCount; i++) {
            total += teamMembers[i].getSalary();
        }
        return total;
    }

    @Override
    public String toString() {
        String text = "TeamLead{" + super.toString() + ",\n  бюджет команди=" + getTotalTeamBudget() + ",\n  команда:";
        for (int i = 0; i < memberCount; i++) {
            text += "\n    - " + teamMembers[i].getName() + " (" + teamMembers[i].getProgrammingLanguage() + ")";
        }
        return text + "\n}";
    }
}
