<template>
  <v-container class="mt-5">
    <v-row justify="end">
      <v-btn depressed dark color="pink"> Create User </v-btn>
    </v-row>
    <v-row align="center" justify="center">
      <v-col>
        <v-data-table
          :headers="headers"
          :items="users"
          :items-per-page="5"
          class="elevation-1"
        ></v-data-table>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
export default {
  name: "AdminCategory",

  data: () => ({
    headers: [
      {
        text: "Username",
        value: "username",
      },
      { text: "Fullname", value: "fullname" },
      { text: "Role", value: "role" },
    ],
    users: [
      { username: "php", fullname: "Huy Phuoc", role: "Admin" },
      { username: "php1", fullname: "Phuoc Huy", role: "Customer" },
      { username: "php2", fullname: "Phuoc Pham", role: "Admin" },
    ],
  }),
};
</script>
<style lang="scss"></style>
