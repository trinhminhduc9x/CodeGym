import {Component, OnInit} from '@angular/core';
import {IWord} from "../iword";
import {DictionaryService} from "../dictionary-service";

@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.css']
})
export class DictionaryComponent implements OnInit {

  dictionarList: IWord[] | undefined;

  constructor(private  dictionaryService: DictionaryService)
  {}

  ngOnInit(): void {
    this.dictionarList = this.dictionaryService.getAll();
  }

}
