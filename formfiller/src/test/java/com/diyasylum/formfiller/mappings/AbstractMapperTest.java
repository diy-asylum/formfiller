package com.diyasylum.formfiller.mappings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class AbstractMapperTest {

  class DogOwner {
    private final String name;
    private final Dog dog;

    DogOwner(String name, Dog dog) {
      this.name = name;
      this.dog = dog;
    }

    String getName() {
      return this.name;
    }

    Dog getDog() {
      return this.dog;
    }
  }

  class Dog {
    private final String name;

    Dog(String name) {
      this.name = name;
    }

    String getName() {
      return this.name;
    }
  }

  class DogMapper extends AbstractMapper<Dog> {

    @Override
    public Map<String, Function<Dog, String>> getFormMapper() {
      return Map.of("dogName", Dog::getName);
    }
  }

  class DogOwnerMapper extends AbstractMapper<DogOwner> {

    @Override
    public Map<String, Function<DogOwner, String>> getFormMapper() {
      Map<String, Function<DogOwner, String>> mapping = new HashMap<>();
      mapping.put("ownerName", DogOwner::getName);
      mapping.putAll(new DogMapper().composeMapping(DogOwner::getDog));
      return mapping;
    }
  }

  @Test
  void composeMapping() {
    DogOwner dogOwner = new DogOwner("Matt", new Dog("Gotham"));
    Map<String, Function<DogOwner, String>> dogOwnerMapping = new DogOwnerMapper().getFormMapper();

    // The dogOwnermapper composes the DogMapper into it

    // First lets see if the mapper has keys from both the DogOwnerMapper and the dogMapperk
    assertEquals(Set.of("dogName", "ownerName"), dogOwnerMapping.keySet());

    // Then lets see if the values mapped correctly
    // I put in a dog owner but it correctly gets the dog out of that and then
    // grabs the name out of that
    assertEquals(dogOwnerMapping.get("ownerName").apply(dogOwner), "Matt");
    assertEquals(dogOwnerMapping.get("dogName").apply(dogOwner), "Gotham");
  }

  @Test
  void altIfTooLong() {
    assertEquals("Batman", AbstractMapper.altIfTooLong("Batman", 6, "Joker"));
    assertEquals("Joker", AbstractMapper.altIfTooLong("Batman", 4, "Joker"));
  }

  @Test
  void naIfBlank() {
    assertEquals("Batman", AbstractMapper.naIfBlank("Batman"));
    assertEquals("N/A", AbstractMapper.naIfBlank(""));
    assertEquals("N/A", AbstractMapper.naIfBlank(" "));
    assertEquals("N/A", AbstractMapper.naIfBlank(null));
  }

  @Test
  void formatCheckbox() {
    assertEquals("Q", AbstractMapper.formatCheckbox(true, "Q"));
    assertEquals("Off", AbstractMapper.formatCheckbox(false, "Q"));
  }

  @Test
  void safeListAccess() {
    List<String> myCoolStrings = Arrays.asList("Radical", "Tubular");
    assertEquals(Optional.of("Radical"), AbstractMapper.safeListAccess(myCoolStrings, 0));
    assertEquals(Optional.of("Tubular"), AbstractMapper.safeListAccess(myCoolStrings, 1));
    assertEquals(Optional.empty(), AbstractMapper.safeListAccess(myCoolStrings, 2));
  }

  @Test
  void noneIfBlank() {
    assertEquals("Batman", AbstractMapper.noneIfBlank("Batman"));
    assertEquals("NONE", AbstractMapper.noneIfBlank(""));
    assertEquals("NONE", AbstractMapper.noneIfBlank(" "));
    assertEquals("NONE", AbstractMapper.noneIfBlank(null));
  }
}
