// Тестирование осуществления поиска по названию и подписки на группу из раздела Группы меню слева
package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.GroupPage;
import pages.GroupsMenuPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GroupsTest extends BaseTest{

    private GroupsMenuPage groupsMenu = new GroupsMenuPage();
    private String groupNameToFind = "Санкт-Петербургский политехнический университет";
    private SelenideElement groupImage= $("img[alt='"+ groupNameToFind+"']");

    @BeforeEach
    public void init(){
        super.init();

        // Предварительно производим логин и переходим в раздел "Группы"
        new LoginPage().signInAs(VALID_USER.getLogin(), VALID_USER.getPassword());
        open("/groups");
    }

    @Test
    public void groupsTest(){
        // Осуществляем поиск группы по названию и сохраняем список результатов
        ElementsCollection searchResults = groupsMenu.searchGroup(groupNameToFind);

        // Открываем страницу группы с заданым назвванием
        GroupPage groupPage = groupsMenu.openGroupPageFromSearch(searchResults, groupNameToFind);

        // Осуществляем подписку
        groupPage.follow();

        // Открываем меню групп, открываем секцию "Мои группы"
        groupsMenu = groupPage.openGroupsMenu();
        groupsMenu.openMyGroupsSection();

        // Проверяем, что отображается элемент-аватарка группы
        groupImage.shouldBe(visible);

    }

    @AfterEach
    public void tearDown(){
        // Отписаться от группы
        open("/groups");
        groupsMenu
                .openMyGroupsSection()
                        .openMyGroup(groupNameToFind)
                                .unfollow();

        // Выходим из аккаунта
        groupsMenu.logOut();
        super.tearDown();
    }
}
