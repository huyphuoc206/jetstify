<template>
  <v-row>
    <v-col>
      <v-row class="align-start">
        <v-col>
          <h1 class="headline font-weight-bold">Browse All</h1>
        </v-col>
      </v-row>
      <v-row>
        <v-col
          cols="12"
          sm="6"
          md="4"
          lg="2"
          v-for="(category, index) in categories"
          :key="index"
        >
          <category-card :category="category"></category-card>
        </v-col>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import {  mapGetters } from "vuex";
import CategoryCard from "@/components/customer/CategoryCard.vue";
export default {
  components: { CategoryCard },
  
  computed: {
    ...mapGetters("category", ["categories"]),
  },
 
};
</script>

<style></style>
