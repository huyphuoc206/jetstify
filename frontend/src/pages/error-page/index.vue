<template>
  <div class="wrapper">
    <v-row class="row" justify="center" align="center">
      <v-col cols="12">
        <div class="status-code text-center">
          <h1>{{ code }}</h1>
        </div>

        <div class="content text-center">
          <h3>Look like you're lost</h3>

          <p>{{ message }}</p>

          <v-btn depressed>Go to Home</v-btn>
        </div>
      </v-col>
    </v-row>
  </div>
</template>

<script>
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
    code() {
      return this.statusCode || this.$route.meta.code || 500;
    },

    message() {
      return this.errorMessage || this.$route.meta.title || "Internal Server Error";
    },
  },
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
    margin-top: -50px;
  }
}
</style>
