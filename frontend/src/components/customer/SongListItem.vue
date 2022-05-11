<template>
  <v-hover v-slot:default="{ hover }">
    <v-list color="#121212">
      <v-list-item class="pl-0" :dense="dense" link>
        <v-list-item-content class="py-0">
          <v-row class="align-center">
            <v-col class="py-0 ml-2" cols="auto"
              ><v-img
                src="https://i.ytimg.com/vi/FN7ALfpGxiI/maxresdefault.jpg"
                width="45px"
                height="60px"
              >
                <v-overlay absolute opacity="0" :value="hover">
                  <v-icon size="25" color="white">mdi-play</v-icon>
                </v-overlay>
              </v-img>
            </v-col>
            <v-col>
              <v-list-item-title>
                <v-list-item-title>
                  <router-link
                    class="text-decoration-none white--text"
                    :to="{
                      name: 'Album',
                      params: {
                        id: 1,
                      },
                    }"
                  >
                    Siento Miedo de Pensar
                  </router-link>
                </v-list-item-title>
                <v-list-item-subtitle>
                  <router-link
                    :style="{
                      color: 'rgba(255, 255, 255, 0.7)',
                    }"
                    class="text-decoration-none"
                    :to="{
                      name: 'Artist',
                      params: {
                        id: 1,
                      },
                    }"
                  >
                    Rosario Alfonso
                  </router-link>
                </v-list-item-subtitle>
              </v-list-item-title>
            </v-col>
          </v-row>
        </v-list-item-content>

        <v-list-item-action :style="{ color: 'rgba(255, 255, 255, 0.7)' }">
          3:49
        </v-list-item-action>
      </v-list-item>
    </v-list>
  </v-hover>
</template>

<script>
export default {
  name: "SongListItem",

  props: ["dense"],
};
</script>
