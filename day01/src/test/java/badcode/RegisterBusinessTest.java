package badcode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegisterBusinessTest {
    @Test
    public void case01(){
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();

        Exception ex1 = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("First name is required.", ex1.getMessage());

        speaker.setFirstName("first name");
        Exception ex2 = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Last name is required.", ex2.getMessage());

        speaker.setLastName("last name");
        Exception ex3 = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Email is required.", ex3.getMessage());

        speaker.setEmail("email");
        Exception ex4 = assertThrows(DomainEmailInvalidException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals(DomainEmailInvalidException.class, ex4.getClass());

        speaker.setEmail("email@ccc.com");
        Exception ex5 = assertThrows( SpeakerDoesntMeetRequirementsException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.", ex5.getMessage());


        speaker.setEmail("email@gmail.com");
        Exception ex6 = assertThrows( SaveSpeakerException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Can't save a speaker.", ex6.getMessage());


        Exception ex7 = assertThrows( SaveSpeakerException.class, () -> {
            business.register(new SpeakerRepository() {
                @Override
                public Integer saveSpeaker(Speaker speaker) {
                    throw  new RuntimeException("can't save");
                }
            }, speaker);
        });
        assertEquals("Can't save a speaker.", ex7.getMessage());


        Integer result = business.register(new SpeakerRepository() {
                @Override
                public Integer saveSpeaker(Speaker speaker) {
                   return  10;
                }
            }, speaker);
        assertEquals(10 , result);
    }
}
