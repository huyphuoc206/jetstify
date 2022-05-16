<template>
  <div>
    <podcast-info />
    <div class="body">
      <podcast-service />
      <v-container>
        <v-row>
          <v-col class="left">
            <podcast-episode-list :episodeList="episodeList" />
          </v-col>

          <v-col class="right">
            <podcast-about :about="about" />
          </v-col>
        </v-row>
      </v-container>
    </div>
  </div>
</template>

<script>
import PodcastAbout from "./components/podcast-about.vue";
import PodcastEpisodeList from "./components/podcast-episode-list.vue";
import PodcastInfo from "./components/podcast-info.vue";
import PodcastService from "./components/podcast-service.vue";
export default {
  name: "Podcast",
  components: {
    PodcastInfo,
    PodcastService,
    PodcastAbout,
    PodcastEpisodeList,
  },

  data: () => ({
    episodeList: [
      {
        id: 1,
        thumbnail:
          "https://i.scdn.co/image/ab6765630000ba8aa9e56b02f9c53ab05fb3984b",
        title: "SAU 11 GIỜ ĐÊM #1 | TÌNH YÊU NÊN ĐI KÈM TỰ DO",
        description:
          "Nếu chỉ có tình yêu thôi, chưa đủ. Vậy để duy trì một tình yêu lâu dài, cần có những yếu tố gì? Đối với mình, tình yêu quan trọng nhất là sự tự do.---Send in a voice message: https://anchor.fm/ng-khnh-vn/message",
        createAt: "15 thg 3",
        time: "16 phút 3 giây",
      },
      {
        id: 2,
        thumbnail:
          "https://i.scdn.co/image/ab6765630000ba8a5ece0f96e96cb0253c4d2d29",
        title: "SAU 11 GIỜ ĐÊM #2 | TÌNH YÊU NÊN ĐI KÈM TỰ DO",
        description:
          "Nếu chỉ có tình yêu thôi, chưa đủ. Vậy để duy trì một tình yêu lâu dài, cần có những yếu tố gì? Đối với mình, tình yêu quan trọng nhất là sự tự do.---Send in a voice message: https://anchor.fm/ng-khnh-vn/message",
        createAt: "10 thg 3",
        time: "16 phút 3 giây",
      },
      {
        id: 3,
        thumbnail:
          "https://i.scdn.co/image/ab6765630000ba8a1a3c24b5c6e6164195dac0d3",
        title: "SAU 11 GIỜ ĐÊM #3 | TÌNH YÊU NÊN ĐI KÈM TỰ DO",
        description:
          "Nếu chỉ có tình yêu thôi, chưa đủ. Vậy để duy trì một tình yêu lâu dài, cần có những yếu tố gì? Đối với mình, tình yêu quan trọng nhất là sự tự do.---Send in a voice message: https://anchor.fm/ng-khnh-vn/message",
        createAt: "20 thg 6",
        time: "16 phút 3 giây",
      },
      {
        id: 4,
        thumbnail:
          "https://i.scdn.co/image/ab6765630000ba8a601a1a61f24cba5df263e685",
        title: "SAU 11 GIỜ ĐÊM #4 | TÌNH YÊU NÊN ĐI KÈM TỰ DO",
        description:
          "Nếu chỉ có tình yêu thôi, chưa đủ. Vậy để duy trì một tình yêu lâu dài, cần có những yếu tố gì? Đối với mình, tình yêu quan trọng nhất là sự tự do.---Send in a voice message: https://anchor.fm/ng-khnh-vn/message",
        createAt: "05 thg 7",
        time: "16 phút 3 giây",
      },
      {
        id: 5,
        thumbnail:
          "https://i.scdn.co/image/ab6765630000ba8ab8b4d78862cfe959d47b4db3",
        title: "SAU 11 GIỜ ĐÊM #5 | TÌNH YÊU NÊN ĐI KÈM TỰ DO",
        description:
          "Nếu chỉ có tình yêu thôi, chưa đủ. Vậy để duy trì một tình yêu lâu dài, cần có những yếu tố gì? Đối với mình, tình yêu quan trọng nhất là sự tự do.---Send in a voice message: https://anchor.fm/ng-khnh-vn/message",
        createAt: "19 thg 06",
        time: "16 phút 3 giây",
      },
      {
        id: 6,
        thumbnail:
          "https://i.scdn.co/image/ab6765630000ba8a7614de14c911094ba458f618",
        title: "SAU 11 GIỜ ĐÊM #6 | TÌNH YÊU NÊN ĐI KÈM TỰ DO",
        description:
          "Nếu chỉ có tình yêu thôi, chưa đủ. Vậy để duy trì một tình yêu lâu dài, cần có những yếu tố gì? Đối với mình, tình yêu quan trọng nhất là sự tự do.---Send in a voice message: https://anchor.fm/ng-khnh-vn/message",
        createAt: "30 thg 2",
        time: "16 phút 3 giây",
      },
    ],

    about:
      "Mây là đám mây hoặc May trong tiếng Anh là tháng 5. Có thể là tháng 5 trong 12 tháng hoặc là “tháng năm” của thời gian. Tất cả tuỳ theo cách bạn hiểu, theo góc nhìn của bạn. Mây Podcast ra đời với mục đích chữa lành, cùng trò chuyện, chia sẻ quan điểm của chúng ta về cuộc sống xung quanh.Hãy lắng nghe lời nhắc nhở thầm lặng của trái tim sau một ngày dài tất bật bạn đã bỏ quên nó. Ở đây là một thế giới của riêng bạn, chỉ bạn có quyền chiêm nghiệm, định đoạt, tưởng tượng ra những điều điên rồ của bạn. Chào mừng bạn đã đến với Mây Poscast!! https://anchor.fm/ng-khnh-vn.",
  }),
};
</script>

<style lang="scss" scoped>
.body {
  background: rgb(205, 202, 207);
  background: linear-gradient(
    180deg,
    rgba(205, 202, 207, 0.9836309523809523) 0%,
    rgba(18, 18, 18, 1) 40%
  );

  .left {
    flex: 1 1 0;
  }

  .right {
    flex: none;
    width: 300px;
  }
}
</style>
