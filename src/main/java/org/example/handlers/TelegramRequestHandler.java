package org.example.handlers;

import org.example.model.entity.chess.ChessBoard;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TelegramRequestHandler extends TelegramLongPollingBot {

    List<BotCommand> listOfCommands = List.of(
            new BotCommand("/start", "начать игру"),
            new BotCommand("/play_online", "играть онлайн"),
            new BotCommand("/play_with_bot", "играть с ботом"),
            new BotCommand("/play_alone", "играть в одиночку"),
            new BotCommand("/surrender", "сдаться"),
            new BotCommand("/offer_draw", "предложить ничью"),
            new BotCommand("/history", "история игр"),
            new BotCommand("/register", "зарегистрироваться"),
            new BotCommand("/login", "войти в аккаунт")
    );
    public void init() throws TelegramApiException {
        this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
    }
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            var message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();
                String chatId = message.getChatId().toString();
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

                InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                inlineKeyboardButton1.setText("Войти в аккаунт");
                inlineKeyboardButton1.setCallbackData("/login");

                InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                inlineKeyboardButton2.setText("Зарегистрироваться");
                inlineKeyboardButton2.setCallbackData("/register");
                rowInline1.add(inlineKeyboardButton1);
                rowInline1.add(inlineKeyboardButton2);

                markupInline.setKeyboard(List.of(rowInline1));

                if (text.startsWith("/start")) {
                    ChessBoard chessBoard = new ChessBoard();
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId().toString());
                    sendMessage.setReplyMarkup(markupInline);
                    sendMessage.setText("Добро пожаловать в наш телеграмм бот по шахматам ♟, для начала игры вам необходимо будет зарегистрироваться или войти в аккаунт.");

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void sendMessage(String text, String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Что-то пошло не так при отправке сообщения");
        }
    }

    public String getBotUsername() {
        return "RomanChessBot";
    }

    public String getBotToken() {
        return "6556557810:AAHNU9-j-S_-XkILVSqHyeUNcbcoHy3gWek";
    }
}
