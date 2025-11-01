package lotto.constant;

public enum OutputMessage {
    MATCH("%,d개 일치"),
    BONUS(", 보너스 볼 일치"),
    PRIZE(" (%,d원) - ,%d개"),
    PROFIT("총 수익률은 %,1.f%%입니다.");

    private final String template;
    OutputMessage(String template) {
        this.template = template;
    }

    public String format(Object... args) {
        return String.format(template, args);
    }
}
