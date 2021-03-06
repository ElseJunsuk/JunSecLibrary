package me.else_junsuk.junseclibrary.playerapi;

import me.else_junsuk.junseclibrary.itemutilapi.CustomItem;
import me.else_junsuk.junseclibrary.stringsapi.F;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class P {

    /**
     * 아래 메서드에서 책 ItemStack을 정의 후,
     * 바로 플레이어에게 펼쳐줍니다.
     * @since 1.2.1
     * @param player - 펼칠 플레이어.
     * @param title - 책의 제목.
     * @param author - 책의 저자.
     * @param content - 책의 내용. ','사용 시 페이지 변경.
     */
    public static void openCreateBook(Player player, String title, String author, String... content) {
        ItemStack book = CustomItem.createBook(title, author, content);
        player.openBook(book);
    }

    /**
     * 책을 플레이어에게 펼쳐줍니다.
     * @since 1.2.1
     * @param player - 펼칠 플레이어.
     */
    public static void openBook(Player player, ItemStack book) {
        player.openBook(book);
    }

    /**
     * 플레이어에게 현재 동결 틱을 설정합니다.
     * (엔티티가 눈 파우더 속에 있었던 틱의 양)
     * @param player
     * @param ticks int - 20틱은 1초와 비례합니다.
     */
    public static void setFreeze(Player player, int ticks) {
        for (int i = 1; i < ticks; i++) {
            player.setFreezeTicks(i);
        }
    }

    /**
     * 플레이어에게 사운드를 들려줍니다.
     * @param player
     * @param location
     * @param sound
     * @param volume
     * @param pitch
     */
    public static void playSound(Player player, Location location, Sound sound, float volume, float pitch) {
        player.playSound(location, sound, volume, pitch);
    }

    /**
     * 플레이어를 특정 위치로 이동 시킨 후 메시지를 출력합니다.
     * @param player
     * @param location
     * @param message
     */
    public static void teleport(Player player, Location location, String message) {
        player.teleport(location.clone().add(0, 0.3, 0));
        F.send(player, message);
    }

    /**
     * 플레이어를 특정 위치로 이동 시키는데,
     * Location클래스속 clone메소드를 사용해
     * 플레이어가 타겟을 중심으로 어느 X,Y,Z좌표를
     * 추가하여 이동시킬지 설정할 수 있습니다.
     * @param player
     * @param location
     * @param clonex double - 위치를 중심으로 추가된 X좌표
     * @param cloney double - 위치를 중심으로 추가된 Y좌표
     * @param clonez double - 위치를 중심으로 추가된 Z좌표
     */
    public static void teleport(Player player, Location location, double clonex, double cloney, double clonez) {
        player.teleport(location.clone().add(clonex, cloney, clonez));
    }

}
