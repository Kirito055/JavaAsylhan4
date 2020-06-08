import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());

        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }


    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        sendMessage.setChatId(message.getChatId().toString());

        sendMessage.setReplyToMessageId(message.getMessageId());

        sendMessage.setText(text);
        try {

            setButtons(sendMessage);
            sendMessage(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void onUpdateReceived(Update update) {
        Model model = new Model();
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/help":
                    sendMsg(message, "В меню ЛОР вы сможете ознакомиться с героями, в меню ПАТЧ вы можете ознакомиться с новейшим Патчем");
                    break;
                case "/GG":
                    sendMsg(message, "GG!");
                    break;
	case "/start":
	     sendMsg(message, "Hello!");
	     break;
	case "/list of heroes":
		sendMsg(message, "Abaddon , Alchemist, Huskar, Gyrocopter, Slark , Void spirit, Storm spirit , Techies");
		break;	
case "/LOR":
	     sendMsg(message, "Введите имя героя:");
	     break;
case "/PATCH":
	     sendMsg(message, "сейчас в игре царствует патч 7.26с. немного устаканили игру, понерфили сильных героев.");
	     break;
case "Abaddon":
	sendMsg(message, "это герой с ближним типом атаки, основной характеристикой которого является сила. Первой способностью,  Mist Coil, Abaddon выпускает смертельный туман, который наносит урон врагу или лечит союзника. Вторая способность,  Aphotic Shield, окружает союзника темной энергией, создавая щит, который поглощает некоторое количество урона перед тем как взорваться и нанести урон ближайшим врагам. Сбрасывает некоторые негативные эффекты и оглушение при применении. Пассивная способность,  Curse of Avernus, после 4-х успешных атак накладывает замораживающее проклятье и безмолвие на атакуемую цель. У всех, кто атакует замедленного врага, на некоторое время повышается скорость атаки и передвижения. Ультимативная способность,  Borrowed Time, при активации позволяет Abaddon обратить любой получаемый им урон в лечение. Снимает большинство негативных эффектов. Если способность готова к применению, она будет активирована пассивно, как только здоровье Abaddon упадет ниже 400. ");

case "Alchemist":
	sendMsg(message, "это герой с ближним типом атаки, основной характеристикой которого является сила. Его первая способность,  Acid Spray, распыляет кислоту по указанной области. Находящиеся в области враги получают периодический урон; кроме этого, их броня временно снижается. Вторая способность,  Unstable Concoction, позволяет Alchemist смешивает взрывоопасные компоненты в колбе, которую может бросить во вражеского героя, оглушая его и нанося урон всем врагам в радиусе взрыва. Чем больше времени Alchemist встряхивает смесь, тем больше урона получат враги, и тем дольше будет длиться оглушение. Через 5 секунд с момента смешивания заклинание достигает максимального эффекта. Однако через 5,5 секунд колба разорвется и оглушит самого Alchemist, если ее не выбросить до этого момента. Пассивная способность,  Greevil's Greed, с каждым убийством юнитов Alchemist получает базовый бонус к золоту, а также дополнительный бонус.");

case "Huskar":
	sendMsg(message, "это герой с дальним типом атаки, основной характеристикой которого является сила. Его первая способность,  Inner Fire, отталкивает всех врагов неподалёку на определённое расстояние, наносит им урон и накладывает на них бессилие. Вторая способность,  Burning Spear, наносит периодический урон огнем. Дополнительный урон складывается с несколькими атаками. Каждая атака поглощает часть здоровья Huskar. Пассивная способность,  Berserker's Blood, увеличивает скорость атаки и восстановление здоровья в зависимости от количества недостающего здоровья. Чем меньше у героя здоровья - тем сильнее бонусы от пассивной способности. Ультимативной способностью,  Life Break, Huskar прыгает к цели в радиусе своей атаки, отнимая часть ее текущего здоровья и замедляя ее. Улучшение с Aghanim's Scepter накладывает провокацию на цель Life Break.");

case "Gyrocopter":
	sendMsg(message, " это герой с дальним типом атаки, основной характеристикой которого является ловкость. Его первая способность,  Rocket Barrage, запускает ракеты залпом на ближайших вражеских юнитов вокруг Gyrocopter, нанося немалый урон. Вторая способность,  Homing Missile, запускает самонаводящуюся ракету в цель. Во время полета ракета набирает скорость, а при столкновении с врагом наносит урон и оглушает его.");

case "Slark":
	sendMsg(message, "это универсальный герой с ближним типом атаки, основной характеристикой которого является ловкость. Первая способность,  Dark Pact, после небольшой задержки Slark жертвует здоровьем, что снимает с него большинство отрицательных эффектов и наносит урон всем врагам поблизости. Сам Slark получает 50% нанесенного этой способностью урона. Второй способностью,  Pounce, Slark прыгает вперед, хватаясь за первого героя, попавшегося ему на пути.");

case "Void spirit":
	sendMsg(message, "герой ближнего боя с основным атрибутом интеллект, который полагается на неожиданность чтобы взрывать врагов силой пустоты. Он действует иначе, по сравнению с другими героями, полагаясь на способности, позволяющие ему заставать врагов врасплох, быстро врываясь в схватку и уходя из неё. Используя свои копии Aether Remnant, Инай может начать и закончить любой бой за секунды, заставляя врагов атаковать остаток себя.");

case "Bristleback":
sendMsg(message, "это герой с ближним типом атаки, основной характеристикой которого является сила. Его первая способность,  Viscous Nasal Goo, снижает броню и скорость передвижения цели. Эффекты от действия способности складываются, а время действия обновляется с каждым повторным применением. Вторая способность,  Quill Spray, выпускает ливень из игл, нанося урон всем врагам вокруг себя. Если в течение следующих 14 секунд цель снова будет атакована иглами, она получит дополнительный урон. Пассивная способность,  Bristleback, снижает получаемый урон от атак в спину и сбоку.");

case "Io":
sendMsg(message, "это герой с дальним типом атаки, основной характеристикой которого является сила. Его первая способность  Tether связывает Io и союзного юнита, увеличивая скорость передвижения обоих. Когда Io пополняет здоровье или ману, привязанный герой тоже восстанавливается, но в умноженном количестве. Связь разрывается, если вы с целью разойдетесь слишком далеко друг от друга, или если Io отменит заклинание. Противник, проходящий через связь Io, замедляется. Вторая способность  Spirits призывает пять духов, которые кружатся вокруг Io нанося урон всем вокруг. При попадании по герою духи взрываются, нанося урон по области. Третья способность  Overcharge увеличивает скорость атаки героя и увеличивает его восстановление здоровья в зависимости от максимального.");

case "Shadow fiend":
sendMsg(message, "это герой с дальним типом атаки, основной характеристикой которого является ловкость. Первые три способности,  Shadowraze, разрывают участок земли перед Shadow Fiend, нанося урон всем врагам в зоне действия. Разница между этими способностями заключается в дальности применения. Первая пассивная способность,  Necromastery, крадет душу каждого убитого врага, давая бонус к атаке. При убийстве героя способность накапливает сразу 12 душ. После смерти половина из них выпускается. Вторая пассивная способность,  Presence of the Dark Lord, снижает броню ближайших врагов. Ультимативная способность,  Requiem of Souls, выпускает собранные души");

case "Sniper":
sendMsg(message, "это герой с дальним типом атаки, основной характеристикой которого является ловкость. Его первая способность,  Shrapnel, использует заряд шрапнели, покрывая указанную область дождем из разрывной дроби. Противники под ним замедляются и получают урон. Раскрывает туман войны в области действия. Первая пассивная способность,  Headshot, дает шанс нанести дополнительный урон и ненадолго остановить противника. Вторая пассивная способность,  Take Aim, увеличивает дальность стрельбы. Ультимативной способностью,  Assassinate");

case "Invoker":
sendMsg(message, "это герой с дальним типом атаки, основной характеристикой которого является интеллект. Это единственный герой в игре, количество способностей которого равно 10 плюс три сферы и ультимативная способность. Сфера  Quas позволяет управлять стихией льда. Каждая активная сфера Quas увеличивает скорость регенерации здоровья. Сфера  Wex позволяет управлять стихией молнии. Каждая активная сфера Wex увеличивает скорость атаки и передвижения. Сфера  Exort позволяет управлять стихией огня. Каждая активная сфера Exort дополнительно увеличивает урон от ваших атак.");

case "Magnus":
sendMsg(message, "это герой с ближним типом атаки, основной характеристикой которого является сила. Его первая способность,  Shockwave, посылает ударную волну, нанося урон врагам на линии ее прохождения. Вторая способность,  Empower, увеличивает урон и наделяет свое оружие или оружие союзника эффектом, который позволяет наносить прорубающий удар. Этот эффект схож с эффектом от Battle Fury icon.png Battle Fury. Третей способностью,  Skewer, Magnus бросается вперед, пронзая врагов своим массивным бивнем. Если на пути попадутся вражеские герои, то их отталкивает к месту назначения, после чего они получат урон и будут замедлены. Ультимативная способность,  Reverse Polarity");

case "Naga siren":
sendMsg(message, "это герой с ближним типом атаки, основной характеристикой которого является ловкость. Ее первая способность,  Mirror Image, создает три иллюзии Naga Siren, которыми можно управлять. Вторая способность,  Ensnare, опутывает цель сетью, прерывает действия цели, не давая двигаться и телепортироваться. Пассивная способность, Rip Tide, даёт шанс Naga Siren и всем её иллюзиям обдать окружающих их врагов мощной волной, которая снижает их броню и наносит урон. Ультимативная способность,  Song of the Siren, позволяет усыпить магическим сном всех врагов рядом с Naga Siren, в котором они не могут ничего делать или быть атакованными.  Song of the Siren End преждевременно завершит заклинание.");


case "Storm spirit":
	sendMsg(message, "это герой с дальним типом атаки, основной характеристикой которого является интеллект. Его первая способность,  Static Remnant, позволяет создавать энергетическую копию Storm Spirit, которая взрывается, если поблизости проходит враг. Вторая способность,  Electric Vortex, создает воронку, притягивающую врага к месту нахождения Storm Spirit, заодно замедляя его. Пассивная способность,  Overload, дает электрический заряд при использовании заклинаний, который высвобождается со следующей атакой, нанося урон врагам поблизости и замедляя их.");

case "Techies":
	sendMsg(message, "это герой с дальним типом атаки, основной характеристикой которого является интеллект. Его первая способность  Proximity Mines, позволяет устанавливает невидимую мину, которая взорвется при приближении врага. Мина также наносит урон строениям. Вторая способность  Stasis Trap, позволяет устанавливает невидимую ловушку, которая оглушает вражеских существ вокруг нее при срабатывании. Третьей способностью  Blast Off! герой совершает опасный прыжок в указанную точку, наносящий огромный урон по площади.");



            }
        }

    }


    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/GG"));
	
        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

    }

    public String getBotUsername() {
        return "AsylBahaBot";
    }

    public String getBotToken() {
        return "871781011:AAHFUv2ISy23-2R8QIabXg6bPs5y-BZ6MmA";
    }
}
