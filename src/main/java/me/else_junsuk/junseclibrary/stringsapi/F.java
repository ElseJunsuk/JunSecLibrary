package me.else_junsuk.junseclibrary.stringsapi;

import me.else_junsuk.junseclibrary.JunSecLibrary;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.conversations.Conversable;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.entity.Player;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Else_JunSuk
 *
 * 아래의 클래스(F)는 Format의 약자로,
 * 소속한 플러그인에 대하여 모든 문자열
 * 을 케어합니다.
 */
public class F {

    /**
     * 버킷에 info, warning로그를 분류하여 출력합니다.
     */
    public static final Logger log = Logger.getLogger("Minecraft");

    /**
     * 콘솔에 메시지를 출력.
     * @warning 본 메서드는 메인 클래스의 메인 인스턴스를 불러오지 못하면 치명적인 오류가 발생할 수 있습니다.
     * @param message
     */
    public static void sendConsole(String msg) {
        JunSecLibrary.getMain().getServer().getConsoleSender().sendMessage(format(msg));
    }

    /**
     * HEX 코드를 사용하기 위해 필요한 패턴 구조.
     */
    public static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    /**
     * 문자열에 포함된 HEX 코드를 색으로 트렌싱.
     * @param message
     * @return String
     */
    public static String format(String msg) {
        if (Bukkit.getVersion().contains("1.17.1")) {
            Matcher match = pattern.matcher(msg);
            while (match.find()) {
                String color = msg.substring(match.start(), match.end());
                msg = msg.replace(color, ChatColor.of(color) + "");
                match = pattern.matcher(msg);
            }
        }
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    /**
     * 한 플레이어에게만 전달합니다.
     * @param player - 플레이어에게 채팅을 출력합니다.
     * @param message
     */
    public static void send(Player p, String msg) {
        p.sendMessage(format(msg));
    }

    /**
     * @param Conversble
     * @param ConversationContext c
     * @param message
     */
    public static void send(Conversable p, ConversationContext c, String msg) {
        p = c.getForWhom();
        p.sendRawMessage(F.format(msg));
    }

    /**
     * 한 플레이어에게만 전달합니다.
     * @param player - 플레이어에게 채팅을 출력합니다.
     * @param title
     * @param subtitle
     * @param in
     * @param stay
     * @param out
     */
    public static void send(Player p, String title, String subtitle, int in, int stay, int out) {
        p.sendTitle(format(title), format(subtitle), in*20, stay*20, out*20);
    }

    /**
     * 모든 플레이어에게 메시지를 전달합니다.
     * @param message
     */
    public static void sendAll(String msg) {
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage(format(msg));
        }
    }

    /**
     * 모든 플레이어에게 타이틀(Title)을 전달합니다.
     * @param title
     * @param subtitle
     * @param in
     * @param stay
     * @param out
     */
    public static void sendAll(String title, String subtitle, int in, int stay, int out) {
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendTitle(format(title), format(subtitle), in*20, stay*20, out*20);
        }
    }

}
