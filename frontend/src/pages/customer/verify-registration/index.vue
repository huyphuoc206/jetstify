<template>
  <v-container class="container d-flex justify-center align-center">
    <v-row v-if="show" align="center" justify="center">
      <v-col cols="12" class="text-center"> 
        <h1>Congratulations, your account has been verified</h1>
        <v-btn class="mt-3" color="primary" @click="goLogin()">Click here to Login</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "VerifyRegistration",
  data: () => ({
    show: false
  }),
  methods: {
    goLogin() {
      this.$router.push({ name: 'Login' });
    },

    async verifyRegistration(key = '') {
      const { success } = await this.$rest.get(`/verify-register?key=${key}`);
      if (success) {
        this.show = true;
      } else {
        this.$router.push('/server-error')
      }
    }
  },
  async created() {
    const key = this.$route.params.key;
    await this.verifyRegistration(key);
  },
};
</script>

<style scoped>
.container {
  height: 100%;
}
</style>
