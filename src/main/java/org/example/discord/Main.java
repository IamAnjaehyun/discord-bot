package org.example.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        //저장소에 올릴 때 token값 감추기 위해 사용(gitignore에 Hide 클래스 선언)
        Hide hide = new Hide();

        JDA jda = JDABuilder.createDefault(hide.getTOKEN()).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("공부하는척"));

        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String prefix = "!";
        Message msg = event.getMessage();
        if (!event.getAuthor().isBot() && args.length == 0) {
            if (args[0].charAt(0) == '!') {
                if (args[0].equalsIgnoreCase("설명")) {
                    if (args.length == 1) {
                        try {
                            event.getChannel().sendMessage("설명중..").queue();
                            Thread.sleep(5000);
                            event.getChannel().sendMessage("설명끝..").queue();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
//                    event.getChannel().sendMessage(event.getMember().getEffectiveName() + "님 에게 " + args[1] +"에 대하여 설명드리겠습니다.").queue();
                        //멘션 기능 추가
                        event.getChannel().sendMessage(event.getAuthor().getAsMention() + "님 에게 " + args[1] + "에 대하여 설명드리겠습니다.").queue();
                        try {
                            event.getChannel().sendMessage("설명중..").queue();
                            Thread.sleep(5000);
                            event.getChannel().sendMessage("설명끝..").queue();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        }
    }
}