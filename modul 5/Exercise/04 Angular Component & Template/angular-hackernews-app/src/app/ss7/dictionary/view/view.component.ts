import { Component, OnInit } from '@angular/core';
import {IWord} from "../iword";
import {DictionaryService} from "../dictionary-service";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  dictionaryView: IWord | undefined;
  index: number | undefined;
  constructor(
    private dictionaryService: DictionaryService,
    private activateRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activateRoute.params.subscribe(
      (params: Params) => {
        this.index = params.index;
        this.dictionaryView = this.dictionaryService.findDictionary(this.index)
      })
  }

}
