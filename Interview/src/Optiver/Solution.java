package Optiver;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


// scope: class Solution
// this seems to be the problematic part of the code

  class Person {
    public String Name = "Unknown";
    public Map<String, String> Traits = new TreeMap<String, String>();
  }


  static Person ConvertRawInputToPerson(String rawInput) {
    Person person = new Solution().new Person();

    String[] traits = rawInput.split(" ");
    for (String trait : traits) {
      String[] keyValuePair = trait.split("=");
      //invalid input
      if(keyValuePair.length > 2){
        return null;
      }
      String key = keyValuePair[0];
      String value = keyValuePair[1];

      if (key.equals("Name")) {
        person.Name = value;
      } else {
        person.Traits.put(key, value);
      }
    }
    return person;
  }


  static boolean StringEquals(String left, String right) {
      return left.equals(right);
  }

  static boolean HasTrait(Map<String, String> traits, Map.Entry<String, String> soughtTrait) {
    String soughtKey = soughtTrait.getKey();
    return (traits.containsKey(soughtKey) && traits.get(soughtKey).equals(soughtTrait.getValue())) ? true : false;
  }

  class Registry {
    List<Person> mPersons = new ArrayList<Person>();

    public void add(Person person) {
      mPersons.add(person);
    }

    public Person findMatchingPersonByRawTraits(String rawTraits)
    {
      Person soughtPerson = ConvertRawInputToPerson(rawTraits);

      for (Person person : mPersons) {
        // if using name as well as traits to find person
        boolean nameCheck = false;
        if(!soughtPerson.Name.equals("Unknown")){
          nameCheck = true;;
        }
        int noOfSoughtTraits = soughtPerson.Traits.size();
        int matchedTraits = 0;
        for (Map.Entry<String, String> soughtTrait : soughtPerson.Traits.entrySet()) {
          if (HasTrait(person.Traits, soughtTrait)) {
            matchedTraits++;
          }
        }
        if(!nameCheck && (matchedTraits == noOfSoughtTraits)){
          return person;
        }
        if(nameCheck &&
                matchedTraits==noOfSoughtTraits &&
                soughtPerson.Name.equals(person.Name)){
          return person;
        }
      }

      Person unknownPerson = new Person();
      return unknownPerson;
    }
  }

  // Entry point
  static String GetNameFromRegistryByTraits(String[] rawRegistry, String soughtTraits) {
    Registry registry = new Solution().new Registry();
    for (String rawInput : rawRegistry) {
      Person toAdd = ConvertRawInputToPerson(rawInput);
      if(toAdd == null){
        return "Error";
      }
      registry.add(ConvertRawInputToPerson(rawInput));
    }

    Person person = registry.findMatchingPersonByRawTraits(soughtTraits);
    return person.Name;
  }

  public static void main(String[] args) throws IOException {
    String[] rawRegistry = {"Name=Xiaoling EyeColor=Blue Age=26 Country=CH", "Name=Pete EyeColor=Brown Age=66 Country=US=&@!#"};
    String soughtTraits = "Country=CH";
    System.out.println(GetNameFromRegistryByTraits(rawRegistry, soughtTraits));

  }
}