<template>
  <v-container class="mt-10">
    <app-confirm
      title="Hello everybody"
      message="Are you sure delete it?"
      :show="false"
      :agree="agree"
      :cancel="agree"
    />
    <v-row justify="end" align="center">
      <v-btn depressed dark color="pink"> Create </v-btn>
    </v-row>
    <v-row align="center" justify="center">
      <v-col cols="12" class="pr-0 pl-0">
        <v-data-table
          dark
          :headers="headers"
          :items="categories"
          @click:row="openDetails()"
        ></v-data-table>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import AppConfirm from "@/components/confirm";

export default {
  name: "AdminCategory",

  components: {
    AppConfirm,
  },

  data: () => ({
    headers: [
      { text: "Category Code", value: "code" },
      { text: "Category Name", value: "name" },
      { text: "Created Date", value: "createdDate" },
      { text: "Updated Date", value: "updatedDate" },
      { text: "Action", value: "updatedDate" },
    ],
    categories: [
      { code: "php", name: "Huy Phuoc", createdDate: new Date() },
      { code: "php1", name: "Phuoc Huy", createdDate: new Date() },
      { code: "php2", name: "Phuoc Pham", createdDate: new Date() },
    ],
  }),

  methods: {
    agree() {
      alert("hello");
    },

    openDetails() {
      alert('hel')
    }
  },
};
</script>
<style lang="scss"></style>
