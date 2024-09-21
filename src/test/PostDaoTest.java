package test;

import com.ssafy.post.dao.PostDao;
import com.ssafy.post.dao.PostDaoImpl;
import com.ssafy.post.model.PostDto;
import com.ssafy.post.model.PostsDto;
import com.ssafy.trip.model.TripDto;
import com.ssafy.trip.model.TripsDto;
import java.sql.Date;
import java.util.List;

public class PostDaoTest {
    static final PostDao postDao = PostDaoImpl.getPostDao();

    public static void main(String[] args) {
        System.out.println("------------ F10. 게시판 CRUD 테스트를 시작합니다. ------------");
        게시판_생성하기();
        게시판_모두_가져오기();
        게시판_pk로_가져오기();
        게시판_유저id로_가져오기();
        게시판_수정하기();
        게시판_삭제하기();
        System.out.println("------------ F10. 게시판 테스트가 종료되었습니다. ------------");
    }

    private static void 게시판_생성하기() {
        PostDto post = new PostDto(
                1,
                "temp",
                "temp content",
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis())
        );

        postDao.createPost(post);
    }

    private static void 게시판_모두_가져오기() {
        System.out.println("게시글을 모두 조회합니다.");
        List<PostDto> posts = postDao.searchPostsAll().getPosts();
        posts.iterator().forEachRemaining(System.out::println);

    }

    private static void 게시판_pk로_가져오기() {
        System.out.println("게시글을 pk로 가져옵니다.");
        PostDto posts = postDao.findById(1);
        System.out.println(posts);
    }

    private static void 게시판_유저id로_가져오기() {
        System.out.println();
        PostsDto posts = postDao.findByMemberId(1);
        posts.getPosts().iterator().forEachRemaining(System.out::println);
    }

    private static void 게시판_수정하기() {
        PostDto posts = postDao.findById(1);

        System.out.println("수정 전 게시글 제목: " + posts.getTitle());

        posts.setTitle("수정된 게시글 제목");
        postDao.modifyPost(posts);

        PostDto modified = postDao.findById(1);
        System.out.println("수정 후 게시글 제목: " + modified.getTitle());
    }

    private static void 게시판_삭제하기() {
        postDao.deletePost(1);
    }
}
