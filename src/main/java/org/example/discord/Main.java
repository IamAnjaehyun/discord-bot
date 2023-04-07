package org.example.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        //저장소에 올릴 때 token값 감추기 위해 사용(gitignore에 Hide 클래스 선언)
        Key key = new Key();
        JDA jda = JDABuilder.createDefault(key.getKey()).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("체크"));

        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        User user = event.getAuthor();
        TextChannel tc = event.getTextChannel();
        Message msg = event.getMessage();

        if (user.isBot()) return;
        if (msg.getContentRaw().charAt(0) == '!') {
            String[] args = msg.getContentRaw().substring(1).split(" ");
            if (args.length == 0) return;
            if (args[0].equalsIgnoreCase("ㅊㅋ")) {
                tc.sendMessage("@everyone" + " 체크").queue();
                tc.sendMessage("https://tenor.com/view/check-green-white-background-gif-16677782").queue();
            } else if (args[0].equalsIgnoreCase("ㄱㄱ")) {
                tc.sendMessage("https://tenor.com/view/police-siren-siren-gif-14993722").queue();
            } else if (args[0].equalsIgnoreCase("ㅂㅌ")) {
                tc.sendMessage("https://tenor.com/view/eating-starving-gif-26035414").queue();
            } else if (args[0].equalsIgnoreCase("ㅎㅅ")) {
                tc.sendMessage("https://tenor.com/view/porn-masturbation-sega-sega-time-pippa-gif-11954428").queue();
            } else if (args[0].equalsIgnoreCase("ㅋㅍ")) {
                tc.sendMessage("https://tenor.com/view/coffee-gif-18759864").queue();
            } else if (args[0].equalsIgnoreCase("ㅌㄱ")) {
                tc.sendMessage("https://tenor.com/view/%ED%8E%AD%EC%88%98-pengsoo-%ED%87%B4%EA%B7%BC-%ED%8E%AD%EC%88%98%ED%87%B4%EA%B7%BC-%ED%8E%AD%EB%B9%A0-gif-19309828").queue();
            }else if (args[0].equalsIgnoreCase("ㅊㄱ")) {
                tc.sendMessage("https://tenor.com/view/%ED%8E%AD%EC%88%98-%EC%B6%9C%EA%B7%BC-penguin-cute-mascot-gif-17850007").queue();
            }else if (args[0].equalsIgnoreCase("ㅂㄱ")) {
                tc.sendMessage("https://tenor.com/view/im-back-im-come-back-comeback-im-here-i-have-returned-gif-15743199").queue();
            }else if (args[0].equalsIgnoreCase("명령어")) {
                tc.sendMessage("!ㅊㅋ → 체크\n!ㅋㅍ → 커피\n!ㅌㄱ → 퇴근\n!ㅊㄱ → 출근\n!ㅂㅌ → 밥탐\n!ㅎㅅ → 휴식\n!ㄱㄱ → 검거\n!ㅂㄱ → 복귀").queue();
            }
        }
    }
}

//            } else if (args[0].equalsIgnoreCase("재니")) {
//                tc.sendMessage( "@재니" + " ㅊㅋ").queue();
//                tc.sendMessage("https://tenor.com/view/police-siren-siren-gif-14993722").queue();
//
//            } else if (args[0].equalsIgnoreCase("아니")) {
//                tc.sendMessage( "@안재현#2906" + " ㅊㅋ").queue();
//                tc.sendMessage("https://tenor.com/view/police-siren-siren-gif-14993722").queue();
//
//            } else if (args[0].equalsIgnoreCase("깝까비")) {
//                tc.sendMessage(event.getMember().getAsMention()+"깝까비").queue();
//                tc.sendMessage("https://tenor.com/view/police-siren-siren-gif-14993722").queue();
//
//            } else if (args[0].equalsIgnoreCase("공책")) {
//                tc.sendMessage( "@김재윤#2619" + " ㅊㅋ").queue();
//                tc.sendMessage("https://tenor.com/view/police-siren-siren-gif-14993722").queue();
//
//            }