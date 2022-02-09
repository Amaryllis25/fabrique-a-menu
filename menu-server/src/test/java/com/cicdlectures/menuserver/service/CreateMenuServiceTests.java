/*package com.cicdlectures.menuserver.service;

import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.ArgumentCaptor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cicdlectures.menuserver.repository.MenuRepository;
import com.cicdlectures.menuserver.repository.DishRepository;
import com.cicdlectures.menuserver.service.ListMenuService;
import com.cicdlectures.menuserver.dto.MenuDto;
import com.cicdlectures.menuserver.dto.DishDto;
import com.cicdlectures.menuserver.model.Dish;
import com.cicdlectures.menuserver.model.Menu;

public class CreateMenuServiceTests {

    private MenuRepository menuRepository;
    private DishRepository dishrepository;

    private CreateMenuService subject;
  
    @BeforeEach
    public void init() {
      this.menuRepository = mock(MenuRepository.class);
      this.dishrepository = mock(DishRepository.class);
      subject = new CreateMenuService(menuRepository, dishrepository);
    }

    @Test
    @DisplayName("Sauvegarde du menu")
    public void saveMenu() {

        MenuDto newMenu = new MenuDto(
            null,
            "C'est l'anniversaire d'Axelle demain!",
            new HashSet<DishDto>(
                Arrays.asList(
                    new DishDto(null, "Turkey"),
                    new DishDto(null, "Tiramisu")
                )
            )
        );

        Menu storedMenu = new Menu(
            Long.valueOf(1),
            "Christmas menu",
             new HashSet<Dish>(
                 Arrays.asList(
                     new Dish(Long.valueOf(2), "Turkey", null),
                     new Dish(Long.valueOf(33), "Tiramisu", null)
                )
            )
        );

        // configure le mock pour qu'il retourne une instance de menu
        when(menuRepository.save(any(Menu.class))).thenReturn(storedMenu);
    
        // On appelle le code a tester...
        subject.createMenu(newMenu);
    
        // On déclare un ArgumentCaptor<Menu> (qui sert a capturer un argument)
        ArgumentCaptor<Menu> savedMenuCaptor = ArgumentCaptor.forClass(Menu.class);
    
        // On vérifie que la méthode `save` du menu repository à été appelée une seule fois
        // et on capture l'argument avec lequel elle a été appelée (le menu).
        verify(menuRepository, times(1)).save(savedMenuCaptor.capture());
    
        // On récupère la valeur capturée pour pouvoir faire des assertions dessus.
        storedMenu = savedMenuCaptor.getValue();
    }
}*/
