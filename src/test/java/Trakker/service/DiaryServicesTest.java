package Trakker.service;

import Trakker.model.Diary;
import Trakker.model.Member;
import Trakker.util.Resources;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class DiaryServicesTest {

    private Member newMember;

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(Diary.class, DiaryServices.class, Resources.class)
                .addClasses(Member.class, MemberRegistration.class, Resources.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                        // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml");
    }


    @Inject
    DiaryServices diaryServices;

    @Inject
    MemberRegistration memberRegistration;

    @Inject
    Logger log;

    @Before
    public void before() throws Exception {
        newMember = new Member();
        newMember.setUsername("Jane Doe");
        newMember.setEmail("jane@mailinator.com");
        newMember.setPhoneNumber("2125551234");
        memberRegistration.register(newMember);
    }

    @Test
    public void testCreateDiary() throws Exception {
        // given
        Diary diary = new Diary();
        diary.setDefaultDiary(true);
        diary.setName("new diary");
        diary.setMemberID(newMember.getId());
        // when
        diaryServices.create(diary);

        //then
        assertNotNull(diary.getId());
        log.info("diray created: " + diary.getId());
    }
}