<template>
  <div class="wrapper">
    <v-row class="row" justify="center" align="center">
      <v-col cols="12">
        <div class="status-code text-center">
          <h1>{{ code }}</h1>
          <h3>{{ message }}</h3>
        </div>

        <div class="content text-center">
          <v-btn depressed @click="goHome()">Go to Home</v-btn>
        </div>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { ROLE_CODE } from "@/core/constants";
export default {
  name: "ErrorPage",
  props: {
    statusCode: {
      type: Number,
      default: null,
    },

    errorMessage: {
      type: String,
      default: null,
    },
  },

  computed: {
    ...mapGetters("auth", ["role"]),
    code() {
      return this.statusCode || this.$route.meta.code || 500;
    },

    message() {
      return this.errorMessage || this.$route.meta.title || "Internal Server Error";
    },
  },

  methods: {
    goHome() {
      if (ROLE_CODE.ADMIN === this.role) {
        this.$router.push({ name: 'AdminHome' });
      } else {
        this.$router.push({ name: 'Home' });
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.wrapper {
  background: #fff;
  color: rgb(73, 71, 71);
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;

  .status-code {
    background-image: url(https://cdn.dribbble.com/users/285475/screenshots/2083086/dribbble_1.gif);
    height: 500px;
    background-position: center;

    h1 {
      font-size: 80px;
    }
  }

  .content {
    margin-top: -100px;
  }
}
</style>
